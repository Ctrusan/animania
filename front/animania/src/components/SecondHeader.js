import React from 'react';
import "../App.css";
import { Switch, Route, Link, Router } from "react-router-dom";
import AnadirAnimal from './anidarAnimal';

function Header ({ appName, user, onAuth, onLogout }) {

    function renderUserData () {

        return (

            <div className='navbar right'>
                <div>
                    <img
                        alt='Header'
                        width="50"
                        className='avatar circle responsive-img'
                        src={user.photoURL}
                    />
                </div>
                <div id="name">{user.displayName}</div>
                <div>
                    <button id="log" className='nav navbar-nav navbar-right'
                            onClick={onLogout}>
                        <strong>Logout</strong>
                    </button>
                </div>
            </div>

        )

    }

function Add () {

    return (

        <Link to={"/add"} className="nav-link">
                Add
              </Link>
    )
}

return (

    <nav className='navbar navbar-inverse navbar-dark bg-dark'>
        <a href='/inicio' alt='Header' className='left navbar-brand'><strong>{appName}</strong></a>
        {user ? renderUserData() : Add()}
    </nav>

)

}

export default Header