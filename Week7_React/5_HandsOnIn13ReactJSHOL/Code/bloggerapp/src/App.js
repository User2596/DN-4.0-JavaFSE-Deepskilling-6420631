import './App.css';
import Details from './Components/Details';
import { books, blogs, courses } from './Components/Data';


function App() {
  return (
    <Details books={books} blogs={blogs} courses={courses} />
  );
}

export default App;
