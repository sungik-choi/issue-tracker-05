const merge = require("webpack-merge");
const TerserPlugin = require("terser-webpack-plugin");
const { CleanWebpackPlugin } = require("clean-webpack-plugin");
const common = require("./webpack.common.js");

module.exports = merge(common, {
  mode: "production",

  devtool: "cheap-module-source-map",

  optimization: {
    splitChunks: {
      cacheGroups: {
        commons: {
          test: /[\\/]node_modules[\\/]/,
          name: "vendors",
          chunks: "all",
        },
      },
    },
    minimize: true,
    minimizer: [
      new TerserPlugin({
        sourceMap: true,
        terserOptions: {
          compress: {
            drop_console: true,
          },
        },
      }),
    ],
  },

  plugins: [new CleanWebpackPlugin()],
});
