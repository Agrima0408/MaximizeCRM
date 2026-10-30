
// Maximize Motors — Dealership Registration Portal
import { api } from "../api.js";
import { h, errorBox } from "../ui.js";

export function renderRegister(root) {
  const banner = h("div", { class: "login-banner-wrap" });

  const name = h("input", {
    type: "text",
    name: "userName",
    id: "register-name",
    placeholder: "Your full name",
    autocomplete: "name",
    required: true,
  });

  const email = h("input", {
    type: "email",
    name: "userEmail",
    id: "register-email",
    placeholder: "advisor@maximizemotors.com",
    autocomplete: "email",
    required: true,
  });

  const phone = h("input", {
    type: "tel",
    name: "userPhone",
    id: "register-phone",
    placeholder: "10-digit phone number",
    autocomplete: "tel",
    required: true,
  });

  const password = h("input", {
    type: "password",
    name: "userPassword",
    id: "register-password",
    placeholder: "Create a password",
    autocomplete: "new-password",
    required: true,
  });

  const confirmPassword = h("input", {
    type: "password",
    id: "register-confirm-password",
    placeholder: "Confirm your password",
    autocomplete: "new-password",
    required: true,
  });

  const btn = h(
    "button",
    {
      class: "btn btn-primary btn-block btn-lg",
      type: "submit",
    },
    "Create Account"
  );

  const form = h(
    "form",
    { novalidate: true, class: "login-form" },

    h("div", { class: "field" },
      h("label", { for: "register-name" }, "Full Name"),
      name
    ),

    h("div", { class: "field" },
      h("label", { for: "register-email" }, "Staff Email Address"),
      email
    ),

    h("div", { class: "field" },
      h("label", { for: "register-phone" }, "Phone Number"),
      phone
    ),

    h("div", { class: "field" },
      h("label", { for: "register-password" }, "Password"),
      password
    ),

    h("div", { class: "field" },
      h("label", { for: "register-confirm-password" }, "Confirm Password"),
      confirmPassword
    ),

    btn
  );

  form.addEventListener("submit", async (e) => {
    e.preventDefault();
    banner.replaceChildren();

    const nameValue = name.value.trim();
    const emailValue = email.value.trim();
    const phoneValue = phone.value.trim();
    const passwordValue = password.value;

    if (!nameValue || !emailValue || !phoneValue || !passwordValue) {
      banner.replaceChildren(errorBox("Please complete all fields."));
      return;
    }

    if (!/^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(emailValue)) {
      banner.replaceChildren(errorBox("Please enter a valid email address."));
      return;
    }

    if (!/^\d{10}$/.test(phoneValue)) {
      banner.replaceChildren(errorBox("Please enter a valid 10-digit phone number."));
      return;
    }

    if (passwordValue.length < 8) {
      banner.replaceChildren(errorBox("Password must contain at least 8 characters."));
      return;
    }

    if (passwordValue !== confirmPassword.value) {
      banner.replaceChildren(errorBox("Passwords do not match."));
      return;
    }

    btn.disabled = true;
    btn.textContent = "Creating Account...";

    try {
      await api.post("/users", {
        userName: nameValue,
        userEmail: emailValue,
        userPassword: passwordValue,
        userPhone: Number(phoneValue),
        userRole: "Sales_Executive",
        userActive: true,
      });

      password.value = "";
      confirmPassword.value = "";

      banner.replaceChildren(
        h("div", { class: "login-success" },
          "Account created successfully! Please log in."
        )
      );

      btn.textContent = "Account Created";
      setTimeout(() => {
        location.hash = "#/login";
      }, 1800);

    } catch (err) {
      banner.replaceChildren(errorBox(
        err.status === 409
          ? "An account with this email already exists."
          : err.message || "Unable to create your account."
      ));

      btn.disabled = false;
      btn.textContent = "Create Account";
    }
  });

  root.replaceChildren(
    h("div", { class: "login-wrap" },
      h("div", { class: "login-card" },

        h("div", { class: "login-brand" },
          h("div", { class: "login-logo-badge" },
            h("span", {}, "M")
          ),
          h("h1", { class: "brand-title" }, "MAXIMIZE MOTORS"),
          h("div", { class: "brand-tag" }, "DEALERSHIP CRM")
        ),

        h("p", { class: "login-subtitle" },
          "Create your sales staff account to access the dealership management system"
        ),

        banner,
        form,

        h("div", { class: "login-footer" },
          h("small", { class: "text-muted" },
            "Already have an account? "
          ),
          h("a", { href: "#/login" }, "Sign In")
        )
      )
    )
  );
}
