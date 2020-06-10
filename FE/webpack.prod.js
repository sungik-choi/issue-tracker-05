const merge = require("webpack-merge");
const common = require("./webpack.common.js");
const TerserPlugin = require("terser-webpack-plugin");
const CleanWebpackPlugin = require("clean-webpack-plugin");

module.exports = merge(common, {
  mode: "production",
<<<<<<< HEAD
=======

  devtool: "cheap-module-source-map",

  output: {
    path: path.join(__dirname, "/dist"),
    filename: "[name].bundle.js",
  },

>>>>>>> 146024a... [Fe/#2] Feat : split chunks 추가 및 소스맵 추가
  optimization: {
    minimize: true,
    minimizer: [
      new TerserPlugin({
        sourceMap: true,
        terserOptions: {
          compress: {
            drop_console: true,
          },
        },
        splitChunks: {
          cacheGroups: {
            commons: {
              test: /[\\/]node_modules[\\/]/,
              name: "vendors",
              chunks: "all",
            },
          },
        },
      }),
    ],
  },

  plugins: [new CleanWebpackPlugin(["dist"])],
});
