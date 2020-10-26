import React, { useState, useEffect } from 'react';
import CompanyProfile from './CompanyProfile';
import axios from 'axios';
import apiHost from 'config';

const CompanyProfileContainer = ({ symbol }) => {

    const [companyProfile, setCompanyProfile] = useState();

    const fetchProfile = symbol => {
        axios.get(`${apiHost}/api/companies/?symbol=${symbol}`)
            .then(response => {
                const profile = response.data;
                setCompanyProfile(formatProfile(profile))
            })
    }

    const formatProfile = profile => {
        const {address, zip, city, state, country, symbol, name, exchange, ipoDate, ceo, sector, noEmployees, industry, image, description, website} = profile;

        return {
            name,

            meta: {
                ceo,
                sector,
                industry,
                website,
                noEmployees
            },

            location: {
                address, zip, city, state, country
            },

            financial: {
                symbol,
                exchange,
                ipoDate
            },

            image,
            description
        }
    }

    useEffect(() => fetchProfile(symbol), [symbol]);

    return  <CompanyProfile profile={companyProfile} />
}
 
export default CompanyProfileContainer;