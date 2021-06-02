import React from 'react';
import "../App.css";

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

function renderLoginButton () {

    return (

        <button id="log" className='nav navbar-nav navbar-right'
                onClick={onAuth}>
            <strong>Login</strong>
        </button>

    )

}

return (

    <nav className='navbar navbar-inverse navbar-dark bg-dark'>
        <a href='/inicio' alt='Header' className='left navbar-brand'><strong>{appName}</strong></a>
        {user ? renderUserData() : renderLoginButton()}
    </nav>

)

}

export default Header