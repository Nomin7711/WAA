import axios from "axios";
import React, { useRef} from "react";

const AddPost = (props) => {
//   const [productState, setProductState] = useState({
//     title: "",
//     author: "",
//     content: "",
//   });
  const addProductForm = useRef(null);
  const handleAdd = () => {
    const form = addProductForm.current;
    const data = {
      title: form.title.value,
      author: form.author.value,
      content: form.content.value,
    };
    axios
      .post(`http://localhost:8080/posts`, data)
      .then(() => {
        // setProductState({
        //   title: "",
        //   author: "",
        //   content: "",
        // });
        form.reset();
        props.fetchData();
      })
      .catch((err) => {
        console.log(err);
      });
  };
  return (
    <div>
      <h3>Add Post</h3>
      <form ref={addProductForm}>
        <input
          type="text"
          placeholder="Title"
          className="input"
        //   value={productState.title}
          name="title"
        //   onChange={(e) =>
        //     setProductState({ ...productState, title: e.target.value })
        //   }
        />
        <input
          type="text"
          placeholder="Author"
          className="input"
        //   value={productState.author}
          name="author"
        //   onChange={(e) =>
        //     setProductState({ ...productState, author: e.target.value })
        //   }
        />
        <input
          type="text"
          placeholder="Content"
          className="input"
        //   value={productState.content}
          name="content"
        //   onChange={(e) =>
        //     setProductState({ ...productState, content: e.target.value })
        //   }
        />
      </form>
      <button
        style={{ background: "rgb(106, 106, 245)", color: "white" }}
        onClick={handleAdd}
      >
        Add
      </button>
    </div>
  );
};
export default AddPost;
