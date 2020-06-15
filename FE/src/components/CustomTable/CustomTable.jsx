import React from "react";
import PropTypes from "prop-types";

import { withStyles } from "@material-ui/core/styles";
import Box from "@material-ui/core/Box";
import Table from "@material-ui/core/Table";
import TableBody from "@material-ui/core/TableBody";
import TableCell from "@material-ui/core/TableCell";
import TableContainer from "@material-ui/core/TableContainer";
import TableHead from "@material-ui/core/TableHead";
import TableRow from "@material-ui/core/TableRow";

const CustomTable = ({ ariaLabel = "table", headContents = null, bodyContents = null }) => {
  return (
    <TableContainer>
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
        <TableBody>
          {bodyContents.map((content) => (
            <TableRow>
              <TableCell>{content}</TableCell>
            </TableRow>
          ))}
        </TableBody>
      </Table>
    </TableContainer>
  );
};

const StyledTableCell = withStyles((theme) => ({
  head: {
    backgroundColor: theme.palette.action.hover,
    color: theme.palette.text.secondary,
  },
}))(TableCell);

CustomTable.propTypes = {
  ariaLabel: PropTypes.string,
  headContents: PropTypes.element,
  bodyContents: PropTypes.arrayOf(PropTypes.element),
};

export default CustomTable;
