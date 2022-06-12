import os
import  tensorflow as tf
import numpy as np
from keras.preprocessing import image

images = os.listdir("/Users/ASUS/Desktop/capstone-project/image")
model = tf.keras.models.load_model('/Users/ASUS/Desktop/capstone-project/klasifikasi jenis tanah4.h5')

print(images)

for i in images:
    print()
    path = '/Users/ASUS/Desktop/capstone-project/image/' + i
    img = image.load_img(path, target_size=(150, 150))
    x = image.img_to_array(img)
    x = np.expand_dims(x, axis=0)
    
    images = np.vstack([x])
    classes = model.predict(images, batch_size=10)
    print(path)
    print(classes)