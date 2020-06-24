const pipe = (...functions) => (arg) => functions.reduce((prev, fn) => fn(prev), arg);

export default pipe;
