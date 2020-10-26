import React from 'react';
import registerProps from './props.js';
import Form from '../index';

const Register = () => (
    <div style={{paddingTop: '3%'}}>
        <Form {...registerProps} />
    </div>
)

export default Register;