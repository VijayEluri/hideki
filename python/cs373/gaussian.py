import math

def gaussian(x, mu, sigma2):
	return 1.0 / math.sqrt(2.0 * math.pi * sigma2) * math.exp(-0.5 * math.pow(x - mu, 2) / sigma2)

print gaussian(8., 10., 4.)
