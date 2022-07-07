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
            paddingBottom: "40px", fontSize: "2.5vw"}}>
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

function Nasa() {
    const [link, setUrl] = React.useState('');
    const [explanation, setDesc] = React.useState('');
    const [title, setTitle] = React.useState('');
    const updateState = (desc, url, title) => {
        setDesc(desc);
        setUrl(url);
        setTitle(title);
    }

    const getImage = () => {
        const api = "MZwupgqfb2TSs5fb582TMbtyLSfhqy5CBiJRdzGB"
        const url = `https://api.nasa.gov/planetary/apod?api_key=${api}`
        fetch(url).then(response => response.json())
            .then((({explanation: explanation1, url: url1, title: title1}) => updateState(explanation1, url1, title1)))
    }

    return (
        <div style={{textAlign: "center", fontFamily: "Times New Roman, Times, serif"}}>
            <Tab />
            <button style={{fontSize: "1vw"}} onClick={getImage}>Get Image</button>
            <h1 style={{fontSize: "3vw"}}>{title}</h1>
            <div style={{paddingTop: "10px"}}>
                <img src={link} width="50%" height="50%" alt={'Nasa apod api'}/>
            </div>
            <section style={{fontFamily: "Times New Roman, Times, serif", textAlign: "center",
                    paddingLeft: "50px", paddingRight: "50px", paddingBottom: "20px"}}>
                <p style={{fontSize: "1.7vw"}}>{explanation}</p>
            </section>
        </div>
    )
}

export default Nasa;