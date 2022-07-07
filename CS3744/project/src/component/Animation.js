/*eslint no-undef: 0*/
import React from 'react'
import {ReactP5Wrapper} from "react-p5-wrapper";
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

function sketch(p5) {
    p5.setup = () => {
        p5.createCanvas();
        p5.pixelDensity(1);
        p5.colorMode(p5.HSB, 1, 1, 1);
        p5.windowResized();
    }

    let points = [];

    p5.init = () => {
        for (let i = 0; i < 250; i++){
            points.push(p5.createVector(p5.random(p5.width), p5.random(p5.height)));
        }
    }

    p5.draw = () => {
        p5.blendMode(p5.NORMAL);
        p5.background(0, .01);
        p5.blendMode(p5.ADD);
        if (points.length === 0) {
            return;
        }

        p5.stroke((p5.frameCount / 100) % 1, 1, 1);
        points[0] = points[0].lerp(p5.createVector(p5.mouseX, p5.mouseY), .5);
        for (let i = 0; i < points.length-1; i++){
            let p1 = points[i];
            let p2 = points[i+1];
            p5.line(p1.x, p1.y, p2.x, p2.y);
            p2 = p2.lerp(p1, .5);
        }
    }

    p5.mousePressed = () =>{
        p5.windowResized()
    }

    p5.windowResized = () => {
        p5.resizeCanvas(p5.windowWidth * 0.6, p5.windowHeight * 0.6);
        p5.init();
    }
}

export function Animation() {
    return (
        <>
            <div style={{textAlign: "center", fontFamily: "Times New Roman, Times, serif"}}>
                <Tab/>
                <b style={{fontSize: "1.9vw"}}>Click or move your mouse to Interact</b>
            </div>
            <div style={{paddingTop: "20px", textAlign: "center", paddingBottom: "20px"}}>
                <ReactP5Wrapper sketch={sketch} />
        </div>
    </>
    );
}



