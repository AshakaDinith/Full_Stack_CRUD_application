import React from 'react'
import { Link } from 'react-router-dom'

export default function Navbar() {
  return (
    <div className='container align-middle'>
    <nav className="navbar navbar-expand-lg navbar-dark bg-primary">
        <Link className="navbar-brand" to="/">Fullstack Application</Link>
        <Link className="btn btn-outline-light" to="/adduser">Add User</Link>
    </nav>
   
    </div>
  )
}
