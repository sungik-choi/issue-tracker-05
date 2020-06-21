export const data = {
  issue: {
    issueId: 1,
    issueTitle: "타이틀",
    milestone: {
      milestoneId: 1,
      milestoneTitle: "마일스톤 제목",
      progress: 33.333,
    },
    attachedLabels: [
      {
        lableId: 1,
        lableName: "레이블 이름1",
        backgroundColor: "#FF5733",
        color: "#FFFFFF",
      },
      {
        lableId: 1,
        lableName: "레이블 이름1",
        backgroundColor: "#FF5733",
        color: "#FFFFFF",
      },
    ],
    author: {
      userId: 1,
      userName: "Hamill",
      avatarUrl:
        "https://lh3.googleusercontent.com/lv3q0LxixvhfsBwhLKzpp53EPMQO92jq98uOKqT9sL0hv4gF8l9bl6SRN23FLxkeJH3ldxZt-PreP1zddg",
      description: "댓글 내용 1",
    },
    allocatedAssignees: [
      {
        userId: 1,
        userName: "Hamill",
        avatarUrl: "https://github.com/hamill/profile&*$#$%",
      },
      {
        userId: 2,
        userName: "Ellin",
        avatarUrl: "https://github.com/hamill/profile&*$#$%",
      },
    ],
    isOpened: true,
    createdAt: "2020-06-09 00:00:00",
    commentInfo: {
      countOfComment: 3,
      comments: [
        {
          commenter: {
            userId: 2,
            userName: "Ellin",
            avatarUrl: "https://github.com/hamill/profile&*$#$%",
          },
          description: "댓글 내용 1",
          createdAt: "2020-06-11 01:00:00",
        },
        {
          commenter: {
            userId: 3,
            userName: "Ed",
            avatarUrl: "https://github.com/hamill/profile&*$#$%",
          },
          description: "댓글 내용 2",
          createdAt: "2020-06-11 02:00:00",
        },
      ],
    },
    labelInfo: {
      countOfLabel: 3,
      labels: [
        {
          lableId: 1,
          lableName: "레이블 이름1",
          backgroundColor: "#FF5733",
          color: "#FFFFFF",
        },
        {
          lableId: 1,
          lableName: "레이블 이름1",
          backgroundColor: "#FF5733",
          color: "#FFFFFF",
        },
      ],
    },
    milestoneInfo: {
      countOfMilestone: 3,
      milestones: [
        {
          milestoneId: 1,
          milestoneTitle: "마일스톤 제목 1",
        },
        {
          milestoneId: 2,
          milestoneTitle: "마일스톤 제목 2",
        },
      ],
    },
    assignees: [
      {
        userId: 1,
        userName: "Hamill",
        avatarUrl: "https://github.com/hamill/profile&*$#$%",
      },
      {
        userId: 2,
        userName: "Ellin",
        avatarUrl: "https://github.com/hamill/profile&*$#$%",
      },
    ],
  },
};
