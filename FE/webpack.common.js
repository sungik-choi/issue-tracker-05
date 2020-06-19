const path = require("path");
const HtmlWebpackPlugin = require("html-webpack-plugin");
const Dotenv = require("dotenv-webpack");

module.exports = {
  entry: "./src/index.js",

  module: {
    rules: [
      {
        test: /\.jsx?$/,
        loader: "babel-loader",
        options: {
          presets: ["@babel/preset-react", "@babel/preset-env"],
          plugins: [
            [
              "@babel/plugin-transform-runtime",
              {
                corejs: 3,
              },
            ],
          ],
        },
        exclude: /node_module/,
      },
    ],
  },

  resolve: {
    alias: {
      "@": path.resolve(__dirname, "src"),
      "@Components": path.resolve(__dirname, "src/components/"),
      "@Pages": path.resolve(__dirname, "src/pages/"),
      "@Styles": path.resolve(__dirname, "src/styles/"),
      "@Mock": path.resolve(__dirname, "src/mock/"),
      "@Utils": path.resolve(__dirname, "src/utils/"),
      "@Public": path.resolve(__dirname, "public/"),
    },
    extensions: [".js", ".jsx"],
  },

  plugins: [
    new HtmlWebpackPlugin({
      template: "./public/index.html",
      filename: "index.html",
      showErrors: true,
    }),
    new Dotenv(),
  ],
};
