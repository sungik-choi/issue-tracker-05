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
            // ! TableRow 내부 key value 삽입 필요
            <TableRow hover>
              <TableCell>
                <Box display="flex" justifyContent="space-between">
                  {content}
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
    backgroundColor: theme.palette.action.hover,
    color: theme.palette.text.secondary,
  },
}))(TableCell);

CustomTable.propTypes = {
  ariaLabel: PropTypes.string.isRequired,
  headContents: PropTypes.element.isRequired,
  bodyContents: PropTypes.arrayOf(PropTypes.element).isRequired,
};

export default CustomTable;
