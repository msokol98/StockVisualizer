import React, { useState } from 'react';
import SelectSearch from 'react-select-search';
import symbols from 'data/symbols';
import './styles.css'; 

const Search = ({ showCompanyProfile }) => {

    const [selectedCompany, setSelectedCompany] = useState();

    const onChange = company => {
        setSelectedCompany(company);
        showCompanyProfile(company)
    }

    const options = symbols.map(data => {
        return {name: data.company, value: data.symbol}
    })
    
    return <SelectSearch 
                options={options} 
                value={selectedCompany} 
                name="Stock Symbol" 
                placeholder="Choose a stock from the S&P 500" 
                onChange={onChange}
                search={true}
            />
}
 
export default Search;