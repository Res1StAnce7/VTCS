import React from 'react';
import {NavLink} from "react-router-dom";

const activeStyle = {
    color: 'red',
    borderBottom: '1em, solid, black',
    textDecoration: 'none'
}

const inactive = {
    color: 'black',
    borderBottom: '1em, solid, black',
    textDecoration: 'none'
}

function Tab() {
    return (
        <div style={{fontFamily: "Times New Roman, Times, serif", paddingTop: "20px",
            paddingBottom: "20px", fontSize: "2.5vw"}}>
            <nav>
                <NavLink style={({ isActive }) => isActive ? activeStyle : inactive}
                         to={"/projects/1"}>Nasa</NavLink> {"| "}
                <NavLink style={({ isActive }) => isActive ? activeStyle : inactive}
                         to={"/projects/2"}>Grid</NavLink> {"| "}
                <NavLink style={({ isActive }) => isActive ? activeStyle : inactive}
                         to={"/projects/3"}>P5</NavLink> {"| "}
                <NavLink style={({ isActive }) => isActive ? activeStyle : inactive}
                         to={"/projects/4"}>D3</NavLink>
            </nav>
        </div>
    );
}

function GirdLayout() {
    function isPrime(n) {
        if (n <= 1) {
            return false;
        }
        for (let i = 2; i < n; i++) {
            if (n % i === 0) {
                return false;
            }
        }
        return true;
    }

    function SingleGrid(number) {
        if (isPrime(number)) {
            return (
                <div style={{color: 'black',
                    textAlign: 'center',
                    backgroundColor: 'red',
                    width: '94%',
                    border: '2px solid black'}}>
                    {number}
                </div>
            )
        }
        else if (number % 2 === 0) {
            return (
                <div style={{color: 'black',
                    textAlign: 'center',
                    backgroundColor: 'green',
                    width: '100%'}}>
                    {number}
                </div>
            )
        }
        else if (Math.abs(number % 2) === 1) {
            return (
                <div style={{color: 'black',
                    textAlign: 'center',
                    backgroundColor: 'yellow',
                    width: '100%'}}>
                    {number}
                </div>
            )
        }
    }

    function Grids(props) {
        let grids = [];
        for (let i = props.start; i <= props.end; i++) {
            grids.push(SingleGrid(i));
        }
        return (
            <div style={{display: "Grid",
                gridTemplateColumns: 'repeat(8, 50px)',
                gridGap: "5px 20px",
                paddingLeft: "5px",
                paddingTop: "5px",
                alignItems: "center",
                justifyContent: "center"
            }}>
                {grids}
            </div>
        )
    }

    return (
        <div style={{textAlign: "center"}}>
            <Tab/>
            <div style={{paddingTop: "20px", paddingBottom: "20px", fontSize: "1.7vw"}}>
                <Grids start={1} end={101} />
            </div>

        </div>
    );
}

export default GirdLayout;