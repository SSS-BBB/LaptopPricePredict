from flask import Flask, request
import numpy as np
import pickle

app = Flask(__name__)

@app.route("/", methods=["GET"])
def hello_world():
    return "Hello World"

@app.route("/", methods=["POST"])
def predict():
    # input from client
    unProcessedInput = str(request.data.decode("utf-8"))

    # create numpy array
    npData = np.array(unProcessedInput.split(","))

    # load model and encoders
    brand_encoder = pickle.load(open("C:/Users/Asus/Desktop/Programming/Java/Projects/LaptopPricePredict/Server/brand_encoder.pkl", "rb"))
    gpu_encoder = pickle.load(open("C:/Users/Asus/Desktop/Programming/Java/Projects/LaptopPricePredict/Server/gpu_encoder.pkl", "rb"))
    processor_encoder = pickle.load(open("C:/Users/Asus/Desktop/Programming/Java/Projects/LaptopPricePredict/Server/processor_encoder.pkl", "rb"))
    resolution_encoder = pickle.load(open("C:/Users/Asus/Desktop/Programming/Java/Projects/LaptopPricePredict/Server/resolution_encoder.pkl", "rb"))
    storage_encoder = pickle.load(open("C:/Users/Asus/Desktop/Programming/Java/Projects/LaptopPricePredict/Server/storage_encoder.pkl", "rb"))
    system_encoder = pickle.load(open("C:/Users/Asus/Desktop/Programming/Java/Projects/LaptopPricePredict/Server/system_encoder.pkl", "rb"))

    model = pickle.load(open("C:/Users/Asus/Desktop/Programming/Java/Projects/LaptopPricePredict/Server/model.pkl", "rb"))

    # convert data
    npData[0] = int(brand_encoder.transform(np.array([npData[0]]))[0]) # Brand
    npData[1] = int(processor_encoder.transform(np.array([npData[1]]))[0]) # Processor
    npData[2] = int(npData[2]) # RAM
    npData[3] = int(storage_encoder.transform(np.array([npData[3]]))[0]) # Storage
    npData[4] = int(gpu_encoder.transform(np.array([npData[4]]))[0]) # GPU
    npData[5] = float(npData[5]) # Screen Size
    npData[6] = int(resolution_encoder.transform(np.array([npData[6]]))[0]) # Resolution
    npData[7] = float(npData[7]) # Battery Life
    npData[8] = float(npData[8]) # Weight
    npData[9] = int(system_encoder.transform(np.array([npData[9]]))[0]) # Operating System

    predicted_price = round(model.predict(npData.reshape(1, -1))[0], 2)

    return str(predicted_price)

if __name__ == "__main__":
    app.run(port=3000, debug=True)