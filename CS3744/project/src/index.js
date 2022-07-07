import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import {BrowserRouter, Routes, Route} from 'react-router-dom';
import Projects from "./component/Projects";
import MyMain from "./component/Main";
import NasaClass from './component/Nasa';
import Page from './component/Page';
import GirdLayout from "./component/Grids";
import {Animation} from "./component/Animation";
import YahooFinance from "./component/YahooFinance";

let data = require('./json/finance.json');
const root = ReactDOM.createRoot(document.getElementById('root'));

root.render(
    <BrowserRouter>
        <Routes>
            <Route path={"/"} element={<Page />}>
                <Route index element={<MyMain />}/>
                <Route path={"/projects"} element={<Projects />}/>
                <Route path={"/projects/1"} element={<NasaClass />}/>
                <Route path={"/projects/2"} element={<GirdLayout />}/>
                <Route path={"/projects/3"} element={<Animation />}/>
                <Route path={"/projects/4"} element={<YahooFinance data={data}/>}/>
            </Route>
        </Routes>
    </BrowserRouter>
);

