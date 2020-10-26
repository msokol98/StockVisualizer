import React, { useState, useEffect } from 'react';
import Portal from './Portal';
import axios from 'axios';
import apiHost from 'config';

const PortalContainer = () => {
    
    const fetchUsersPortfoilio = () => {
        // axios.get(`${apiHost}`)
    } 

    useEffect(fetchUsersPortfoilio, []);

    return <Portal />

}
 
export default PortalContainer;