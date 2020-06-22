export const userList = [
  {
    id: "pororo1",
    url:
      "https://lh3.googleusercontent.com/lv3q0LxixvhfsBwhLKzpp53EPMQO92jq98uOKqT9sL0hv4gF8l9bl6SRN23FLxkeJH3ldxZt-PreP1zddg",
  },
  {
    id: "pororo2",
    url:
      "https://lh3.googleusercontent.com/lv3q0LxixvhfsBwhLKzpp53EPMQO92jq98uOKqT9sL0hv4gF8l9bl6SRN23FLxkeJH3ldxZt-PreP1zddg",
  },
  {
    id: "pororo3",
    url:
      "https://lh3.googleusercontent.com/lv3q0LxixvhfsBwhLKzpp53EPMQO92jq98uOKqT9sL0hv4gF8l9bl6SRN23FLxkeJH3ldxZt-PreP1zddg",
  },
  {
    id: "pororo4",
    url:
      "https://lh3.googleusercontent.com/lv3q0LxixvhfsBwhLKzpp53EPMQO92jq98uOKqT9sL0hv4gF8l9bl6SRN23FLxkeJH3ldxZt-PreP1zddg",
  },
  {
    id: "pororo5",
    url:
      "https://lh3.googleusercontent.com/lv3q0LxixvhfsBwhLKzpp53EPMQO92jq98uOKqT9sL0hv4gF8l9bl6SRN23FLxkeJH3ldxZt-PreP1zddg",
  },
];

const FILTER_BY_TEXT = "Filter by";

export const filterButtonList = [
  {
    type: "Author",
    menuTitle: `${FILTER_BY_TEXT} Author`,
    menuList: [
      {
        text: "Unlabeled",
        clickHandler: null,
      },
      {
        text: "Pororo123",
        avatar: {
          id: "pororo",
          url:
            "https://lh3.googleusercontent.com/lv3q0LxixvhfsBwhLKzpp53EPMQO92jq98uOKqT9sL0hv4gF8l9bl6SRN23FLxkeJH3ldxZt-PreP1zddg",
        },
        name: "roro po",
        clickHandler: null,
      },
    ],
  },
  {
    type: "Label",
    menuTitle: `${FILTER_BY_TEXT} Label`,
    menuList: [
      {
        text: "Unlabeled",
        clickHandler: null,
      },
      {
        text: "something is wrong",
        label: {
          name: "BUG",
          backgroundColor: "#000",
          color: "#FFF",
        },
      },
      {
        text: "Front end",
        label: {
          name: "FE",
          backgroundColor: "#FFC821",
          color: "#333333",
        },
      },
    ],
  },
  {
    type: "Milestone",
    menuTitle: `${FILTER_BY_TEXT} Milestone`,
    menuList: [
      {
        text: "Unlabeled",
        clickHandler: null,
      },
    ],
  },
  {
    type: "Assignee",
    menuTitle: `${FILTER_BY_TEXT} who's assigned`,
    menuList: [
      {
        text: "Unlabeled",
        clickHandler: null,
      },
    ],
  },
];
