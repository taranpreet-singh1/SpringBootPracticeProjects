
import {useParams, Link} from 'react-router-dom'

function WelcomeComponent(){

    const {username} = useParams()

    

    return(
        <div className="Welcome">
            <h1>Welcome {username}</h1>
            <div>Your todos <Link to="/todos">Go here</Link></div>
        </div>
    )
}


export default WelcomeComponent