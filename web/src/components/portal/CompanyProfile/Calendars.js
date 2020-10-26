import React, { useState } from 'react';
import Calendar from 'react-calendar';
import 'react-calendar/dist/Calendar.css';

const StockCalendar = ({ startDate, setStartDate, endDate, setEndDate }) => (

    <div className="columns">
        <div className="column">
            <Calendar
                onChange={setStartDate}
                value={startDate}
            />
        </div>

        <div className="column">
            <Calendar
                onChange={setEndDate}
                value={endDate}
            />        
        </div>

    </div>
    
)

export default StockCalendar;