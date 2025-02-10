from flask import Flask, request

app = Flask(__name__)

@app.route("/", methods=["GET"])
def hello_world():
    return "Hello World"

@app.route("/", methods=["POST"])
def predict():
    print(request.data)
    return "Ayo!"

if __name__ == "__main__":
    app.run(port=3000, debug=True)