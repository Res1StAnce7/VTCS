import {Link} from "react-router-dom";
import React from "react";
import AppBar from '@mui/material/AppBar';
import Toolbar from '@mui/material/Toolbar';
import styled from '@emotion/styled';

const Links = styled.div`
  text-decoration: none;
  color: black;
  font-size: 20px;
  margin-left: 10px;
  &:hover {
    color: red;
  }
`

function Header() {
    return (
        <AppBar position="static">
            <Toolbar style={{textAlign: "center", paddingTop: "10px", fontFamily: "Times New Roman, Times, serif"}}>
                <div>
                    <Link to="/" style={{fontSize: "2.5vw", textDecoration: "none"}}>
                        <Links>Home</Links>
                    </Link>
                </div>
                <div>
                    <Link to="/projects" style={{fontSize: "2.5vw", textDecoration: "none"}}>
                        <Links>Projects Overview</Links>
                    </Link>
                </div>
            </Toolbar>
        </AppBar>
    );
}

export default Header;