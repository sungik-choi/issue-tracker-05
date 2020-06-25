import { hex } from "wcag-contrast";
import pipe from "./pipe";

const getRandomIntInclusive = (min, max) => Math.floor(Math.random() * (max - min + 1)) + min;

const getRandomRgbColorObj = () => {
  const MIN_COLOR_NUM = 1;
  const MAX_COLOR_NUM = 255;

  return {
    red: getRandomIntInclusive(MIN_COLOR_NUM, MAX_COLOR_NUM),
    green: getRandomIntInclusive(MIN_COLOR_NUM, MAX_COLOR_NUM),
    blue: getRandomIntInclusive(MIN_COLOR_NUM, MAX_COLOR_NUM),
  };
};

const rgbToHex = ({ red, green, blue }) => {
  let r = red.toString(16);
  let g = green.toString(16);
  let b = blue.toString(16);

  if (r.length === 1) r = `0${r}`;
  if (g.length === 1) g = `0${g}`;
  if (b.length === 1) b = `0${b}`;

  return `#${r}${g}${b}`;
};

const getProperContrastColor = (backgroundColor) => {
  const white = "#FFFFFF";
  const black = "#000000";
  const PROPER_RATIO = 3;

  return hex(backgroundColor, white) > PROPER_RATIO
    ? { backgroundColor, color: white }
    : { backgroundColor, color: black };
};

const generateRandomColor = () => pipe(getRandomRgbColorObj, rgbToHex, getProperContrastColor)();

export default generateRandomColor;
