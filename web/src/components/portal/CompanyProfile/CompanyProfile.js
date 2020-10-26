import React from 'react';
import './styles.css';
import Calendars from './CalendarsContainer';

const CompanyProfile = ({ profile }) => {

    if(!profile) return <></>
    
    let {name, meta, financial, location, image, description} = profile;

    location = getJSX("Location", Object.entries(location));
    meta = getJSX("About", Object.entries(meta));
    financial = getJSX("Financial", Object.entries(financial));

    return(
        <div className="profile has-background-light ">

            <div className="profile-padded">
                <h3>Company Profile for {name}</h3>
                <img width="200" src={image} alt={name} />
            </div>

            <Calendars />

            <div className="columns">

                <div className="column">    
                    {meta}
                    <br />
                    {location}
                </div>

                <div className="column">
                    {financial}
                </div>

            </div>

            <div>
                <h2>    
                    Description
                </h2>
                <p>{description}</p>
            </div>
        </div>
    )

}

const getJSX = (title, entries) => (
    <div className="profile-padded">
        <h2>
            {title}
        </h2>

        {entries.map(pair => {
            const key = pair[0];
            const value = pair[1];
            const valueJSX = key === "website" ? <a href={value} target="_blank">{value}</a> : <span>{value}</span>

            return(
                <h6>
                    <span className="has-text-grey profile-key">{key}: </span>
                    {valueJSX}
                </h6>
            )
        })}
    </div>   
)

export default CompanyProfile;