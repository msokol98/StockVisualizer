import pandas as pd
import psycopg2

df = pd.read_csv('../stocks.csv')

conn = psycopg2.connect(
    host="localhost",
    database="stockvisualizerdb",
    user="postgres",
    password="a"
)
cur = conn.cursor()

for row in df.iterrows():
    data = row[1]
    symbol = data[0]

    cur.execute("INSERT INTO Company (symbol) values(%s)",
        (symbol, ))

conn.commit()
cur.close()
conn.close()
