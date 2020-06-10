const path = require("path");
const HtmlWebpackPlugin = require("html-webpack-plugin");
const Dotenv = require('dotenv-webpack');
const CleanWebpackPlugin = require('clean-webpack-plugin');

module.exports = {
  entry: "./src/index.jsx",
  output: {
    path: path.join(__dirname, "/dist"),
    filename: "index_bundle.js",
  },
  module: {
    rules: [
      {
        test: /\.js$/,
        exclude: /node_module/,
        use: {
          loader: "babel-loader",
        },
      },
    ],
  },
  resolve: {
    extensions: ['.js', '.jsx']
  },
  // common
  plugins: [ 
    new Dotenv(),
  ],
  // dev
  plugins: [ 
    new HtmlWebpackPlugin({
      template: "./public/index.html",
      filename: 'index.html'
    }),
  ],
  // prod
  plugins: [ 
    new HtmlWebpackPlugin({
      template: "./public/index.html",
      filename: 'index.html'
    }),
    new CleanWebpackPlugin(['dist']),
  
};
