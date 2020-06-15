import { createGlobalStyle, css } from "styled-components";
import reset from "styled-reset";

const variables = css`
  :root {
    --button-border: 1px solid rgba(27, 31, 35, 0.2);
    --popup-backgroundColor: #f6f8fa;
  }
`;

const GlobalStyle = createGlobalStyle`
  ${reset}
  ${variables}
  
  * {
    font-size: 14px;
  }

  html, body {
    width: 100%;
    height: 100%;
    font-family: 'Noto Sans KR', sans-serif;
  
  }
  
 button {
  border: none;
  margin: 0;
  padding: 0;
  width: auto;
  background: transparent;
 }

`;

export default GlobalStyle;
