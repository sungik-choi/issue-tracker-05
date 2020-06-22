import PropTypes from "prop-types";

const { shape, arrayOf } = PropTypes;

export const assigneeType = arrayOf(
  shape({
    id: PropTypes.number.isRequired,
    name: PropTypes.string.isRequired,
    avatarUrl: PropTypes.string.isRequired,
  }),
);

export const detailsType = shape({
  createdAt: PropTypes.string.isRequired,
  milestone: shape({
    title: PropTypes.string.isRequired,
  }).isRequired,
  author: shape({
    name: PropTypes.string.isRequired,
  }).isRequired,
});

export const labelType = arrayOf(
  shape({
    id: PropTypes.number.isRequired,
    name: PropTypes.string.isRequired,
    backgroundColor: PropTypes.string.isRequired,
    color: PropTypes.string.isRequired,
  }),
);

export const issueType = shape({
  title: PropTypes.string.isRequired,
  attachedLabels: labelType.isRequired,
  detailsType,
});
