import styled from "@emotion/styled";

const Button = styled.button`
  background-color: white;
  color: black;
  font-size: 15px;
  padding: 10px;
  margin: 0 23px;
  cursor: pointer;
  border: none;
`;

const Text = styled.div`
  font-size: 12px;
`;

const StyledPopover = styled.div`
  .popover {
    max-width: 600px;
    padding: 0px 10px 10px 10px;
  }
`;

export { Button, Text, StyledPopover };
