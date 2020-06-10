const path = require("path");
const HtmlWebpackPlugin = require("html-webpack-plugin");
const Dotenv = require("dotenv-webpack");

module.exports = {
  entry: "./src/index.jsx",

  module: {
    rules: [
      {
        test: /\.js$/,
        options: {
          presets: ["@babel/preset-react", "@babel/preset-env"],
        },
        loader: "babel-loader",
        exclude: /node_module/,
      },
    ],
  },

  resolve: {
    alias: {
      Components: path.resolve(__dirname, "./src/components/"),
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
