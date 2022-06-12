import tensorflow as tf

model = tf.keras.models.load_model('/Users/ASUS/Desktop/capstone-project/klasifikasi jenis tanah7.h5')
converter = tf.lite.TFLiteConverter.from_keras_model(model)
tflite_model = converter.convert()
with open('/Users/ASUS/Desktop/capstone-project/klasifikasi jenis tanah7.tflite', 'wb') as f:
  f.write(tflite_model)