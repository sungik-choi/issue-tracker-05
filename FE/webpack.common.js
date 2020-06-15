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
      Components: path.resolve(__dirname, "./src/components/"),
      Pages: path.resolve(__dirname, "./src/pages/"),
      Styles: path.resolve(__dirname, "./src/styles/"),
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
