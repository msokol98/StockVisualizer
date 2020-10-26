import React, { useState } from 'react';
import axios from 'axios';
import apiHost from 'config';

const CalendarsContainer = () => {

    const [startDate, setStartDate] = useState();
    const [endDate, setEndDate] = useState();

    const [startPrice, setStartPrice] = useState();
    const [endPrice, setEndPrice] = useState();

    const fetchPrice = date => {
        axios.get(`${apiHost}/api/stock_days`, date)
            .then(response => console.log(response.data))
    }

    return(
        <CalendarsContainer
            startDate={startDate}
            endDate={endDate}
            setStartDate={setStartDate}
            setEndDate={setEndDate}
            fetchPrice={fetchPrice}
        />
    ) 
}
 
export default CalendarsContainer;