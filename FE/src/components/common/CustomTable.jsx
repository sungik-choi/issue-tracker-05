import React from "react";
import PropTypes from "prop-types";

import { makeStyles, withStyles } from "@material-ui/core/styles";
import Box from "@material-ui/core/Box";
import Table from "@material-ui/core/Table";
import TableBody from "@material-ui/core/TableBody";
import TableCell from "@material-ui/core/TableCell";
import TableContainer from "@material-ui/core/TableContainer";
import TableHead from "@material-ui/core/TableHead";
import TableRow from "@material-ui/core/TableRow";
import Paper from "@material-ui/core/Paper";

const CustomTable = ({ ariaLabel, headContents, bodyContents }) => {
  const classes = useStyles();

  return (
    <TableContainer component={Paper} variant="outlined">
      <Table aria-label={ariaLabel}>
        <TableHead>
          <TableRow>
            <StyledTableCell>
              <Box display="flex" justifyContent="space-between">
                {headContents}
              </Box>
            </StyledTableCell>
          </TableRow>
        </TableHead>
        <TableBody className={classes.table}>
          {bodyContents.map(({ id, contents }) => (
            <TableRow hover key={id}>
              <TableCell>
                <Box display="flex" justifyContent="space-between">
                  {contents}
                </Box>
              </TableCell>
            </TableRow>
          ))}
        </TableBody>
      </Table>
    </TableContainer>
  );
};

const StyledTableCell = withStyles((theme) => ({
  head: {
    backgroundColor: theme.palette.grey[100],
    color: theme.palette.text.secondary,
  },
}))(TableCell);

const useStyles = makeStyles(() => ({
  table: {
    "& tr:last-child > td": {
      borderBottom: "none",
    },
  },
}));

CustomTable.defaultProps = {
  ariaLabel: "table",
};

CustomTable.propTypes = {
  ariaLabel: PropTypes.string,
  headContents: PropTypes.element.isRequired,
  bodyContents: PropTypes.arrayOf(
    PropTypes.shape({
      id: PropTypes.number.isRequired,
      contents: PropTypes.element.isRequired,
    }),
  ).isRequired,
};

export default CustomTable;
