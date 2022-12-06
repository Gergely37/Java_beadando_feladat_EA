module.exports = {
  content: ["./src/main/resources/templates/**/*.{html,js}"],
  theme: {
    extend: {},
  },
  plugins: [require("daisyui")],
  daisyui: {
    themes: ["emerald","forest"],
  },
}