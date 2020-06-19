import moment from "moment";

const DAY = "day";
const HOUR = "hour";
const MINUTE = "minute";
const SECOND = "second";

const getPluralWord = (target, word) => (target > 1 ? `${word}s` : word);

const calcTimeDiff = (time) => {
  const previousTime = moment(time, "YYYY-MM-DD HH:mm:ss");
  const currentTime = moment();

  const day = moment.duration(currentTime.diff(previousTime)).days();
  if (day) return `${day} ${getPluralWord(day, DAY)}`;

  const hour = moment.duration(currentTime.diff(previousTime)).hours();
  if (hour) return `${hour} ${getPluralWord(hour, HOUR)}`;

  const minute = moment.duration(currentTime.diff(previousTime)).minutes();
  if (minute) return `${minute} ${getPluralWord(minute, MINUTE)}`;

  const second = moment.duration(currentTime.diff(previousTime)).seconds();
  if (second) return `${second} ${getPluralWord(second, SECOND)}`;

  return "";
};

export default calcTimeDiff;
