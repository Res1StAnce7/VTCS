function Content() {
    return (
        <div >
            <div>
                <a href={"/projects/1"}  style={{textDecoration: "none", color: "black"}}>
                    <b style={{fontSize: "2vw"}}>NASA Homework</b>
                </a>
                <div style={{height: "100px", display:"inline-grid", justifyContent:"center", alignItems:"center",
                    paddingLeft: "100px", paddingRight: "100px"}}>
                    <a href={"/projects/1"} style={{textDecoration: "none", color: "black", fontSize: "1.7vw"}}>
                        The first project is about exploring APOD NASA API.
                        When the user clicks the button, a request will be sent to APOD API by NASA.
                        The response received from the server will be process and the information about
                        the received object will be displayed which consists of Astronomy Picture
                        of the Day and its detailed explanation.
                    </a>
                </div >
                <a href={"/projects/1"}>
                    <img style={{paddingTop: "2vw"}} src={require("../picture/P1.png")} width="40%" height="50%"
                         alt={"p1"}/>
                </a>
            </div>

            <div style={{paddingTop: "3vw"}}>
                <a href={"/projects/2"}  style={{textDecoration: "none", color: "black"}}>
                    <b style={{fontSize: "2vw"}}>Grid Layout</b>
                </a>
                <div style={{height: "100px", display:"inline-grid", justifyContent:"center", alignItems:"center",
                    paddingLeft: "100px", paddingRight: "100px", textDecoration: "none"}}>
                    <a href={"/projects/2"} style={{textDecoration: "none", color: "black", fontSize: "1.7vw"}}>
                        The second project is about using the CSS grid layout to create the grid.
                        Depending on the number, even, odd, or prime, the style of each block will change.
                        For the odd numbers, the block's color is yellow; for the even numbers,
                        the block's color is green and for the prime numbers, the block's color is red
                        with a solid black border.
                    </a>
                </div>
                <a href={"/projects/2"}>
                    <img style={{paddingTop: "2vw"}} src={require("../picture/P2.png")} width="40%" height="50%"
                         alt={"p2"}/>
                </a>
            </div>

            <div style={{paddingTop: "3vw"}}>
                <a href={"/projects/3"}  style={{textDecoration: "none", color: "black"}}>
                    <b style={{fontSize: "2vw"}}>P5</b>
                </a>
                <div style={{height: "100px", display:"inline-grid", justifyContent:"center", alignItems:"center",
                    paddingLeft: "100px", paddingRight: "100px", textDecoration: "none"}}>
                    <a href={"/projects/3"} style={{textDecoration: "none", color: "black", fontSize: "1.7vw"}}>
                        The third project is about creative coding with P5. p5.js is a JavaScript
                        library for creative coding, with a focus on making coding accessible.
                        The content can be interacted will mouse click and mouse movement.
                    </a>
                </div>
                <a href={"/projects/3"}>
                    <img style={{paddingTop: "2vw"}} src={require("../picture/P3.png")} width="40%" height="30%"
                         alt={"p3"}/>
                </a>
            </div>

            <div style={{paddingTop: "3vw"}}>
                <a href={"/projects/4"}  style={{textDecoration: "none", color: "black"}}>
                    <b style={{fontSize: "2vw"}}>D3</b>
                </a>
                <div style={{height: "100px", display:"inline-grid", justifyContent:"center", alignItems:"center",
                    paddingLeft: "100px", paddingRight: "100px", textDecoration: "none"}}>
                    <a href={"/projects/4"} style={{textDecoration: "none", color: "black", fontSize: "1.7vw"}}>
                        The last project has the layout created with D3. The JSON file fetched request
                        from Yahoo finance chart API is used to create the chart. When the mouse is over
                        the data (mouseover event), the data value will be displayed.
                    </a>
                </div>
                <a href={"/projects/4"}>
                    <img style={{paddingTop: "2vw"}} src={require("../picture/P4.png")} width="40%" height="30%"
                         alt={"p4"}/>
                </a>
            </div>
        </div>
    );
}

function Projects() {
    return (
        <div style={{paddingTop: "20px", textAlign: "center", fontFamily: "Times New Roman, Times, serif"}}>
            <Content/>
        </div>
    )
}

export default Projects;