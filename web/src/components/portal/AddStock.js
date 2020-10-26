import React, { useState } from 'react';
import Search from './Search';
import CompanyProfile from './CompanyProfile/CompanyProfileContainer'

const AddStock = () => {

    const [company, setCompany] = useState();

    return(
        <div className="green" style={{minHeight: "calc(100vh - 70px)", display: "flex", justifyContent: "center"}}>
            <div style={{padding: "2%", display: "flex", alignItems: "center", flexDirection: "column"}}>
                <h3 className="has-text-white">View profile of an S&P 500 company</h3>
                <br></br>
                <Search showCompanyProfile={setCompany} />
                <br /><br />
                <CompanyProfile symbol={company} />
            </div>
        </div>
    )
}
 
export default AddStock;