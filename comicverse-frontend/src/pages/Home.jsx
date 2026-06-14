import { useEffect, useState } from "react";
import api from "../api/api";

function Home() {
    const [comics, setComics] = useState([]);

    useEffect(() => {
        const loadComics = async () => {
            try {
                const response = await api.get("/comics");
                setComics(response.data);
            } catch (error) {
                console.error("Error fetching comics:", error);
            }
        };

        loadComics();
    }, []);

    return (
        <div>
            <h1>Home Page</h1>

            {comics.map((comic) => (
                <div
                    key={comic.id}
                    style={{
                        border: "1px solid #444",
                        padding: "20px",
                        margin: "20px",
                        borderRadius: "10px",
                        width: "300px"
                    }}
                >
                    <div key={comic.id}>
                        <img
                            src={`http://localhost:8080/covers/${comic.coverImageUrl}`}
                            alt={comic.title}
                            width="250"
                        />

                        <p>{comic.coverImageUrl}</p>

                        <h2>{comic.title}</h2>

                        <p>
                            <strong>Author:</strong> {comic.author}
                        </p>

                        <p>
                            <strong>Genre:</strong> {comic.genre}
                        </p>

                        <p>{comic.description}</p>
                    </div>

                    <h2>{comic.title}</h2>

                    <p>
                        <strong>Author:</strong> {comic.author}
                    </p>

                    <p>
                        <strong>Genre:</strong> {comic.genre}
                    </p>

                    <p>{comic.description}</p>
                </div>
            ))}
        </div>
    );
}

export default Home;