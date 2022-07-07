import Header from "./Header";
import MyFooter from "./Footer";
import {Outlet} from "react-router-dom";

function Page() {
    return (
        <>
            <Header />
                <Outlet />
            <MyFooter />
        </>
    )
}

export default Page;