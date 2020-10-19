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
    name = data[1]
    sector = data[2]

    cur.execute("INSERT INTO Stock(symbol, name, sector, current_share_price) values(%s, %s, %s, %s)", 
        (symbol, name, sector, 0))

conn.commit()
cur.close()
conn.close()