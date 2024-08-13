class Product:
def __init__(self, name, description, category, price, ingredients, images):
self.name = name
self.description = description
self.category = category
self.price = price
self.ingredients = ingredients
self.images = images

def update_product(self, name=None, description=None, category=None, price=None, ingredients=None, images=None):
        if name:
self.name = name
        if description:
self.description = description
        if category:
self.category = category
        if price:
self.price = price
        if ingredients:
self.ingredients = ingredients
        if images:
self.images = images

class Inventory:
def __init__(self):
self.products = []

def add_product(self, product):
        self.products.append(product)

def remove_product(self, product_name):
self.products = [p for p in self.products if p.name != product_name]

def get_product(self, product_name):
        for product in self.products:
        if product.name == product_name:
        return product
        return None

class SalesDashboard:
def __init__(self):
self.sales_data = {}

def record_sale(self, product_name, quantity, price):
        if product_name in self.sales_data:
self.sales_data[product_name]['quantity'] += quantity
self.sales_data[product_name]['revenue'] += price * quantity
        else:
self.sales_data[product_name] = {'quantity': quantity, 'revenue': price * quantity}

def get_sales_report(self):
        return self.sales_data

def get_best_selling_products(self):
        return sorted(self.sales_data.items(), key=lambda item: item[1]['revenue'], reverse=True)

class DiscountManager:
def __init__(self):
self.discounts = {}

def set_discount(self, product_name, discount_percentage):
self.discounts[product_name] = discount_percentage

def apply_discount(self, product_name, price):
        if product_name in self.discounts:
        return price * (1 - self.discounts[product_name] / 100)
        return price

class Message:
def __init__(self, sender, receiver, content):
self.sender = sender
self.receiver = receiver
self.content = content

class MessagingSystem:
def __init__(self):
self.messages = []

def send_message(self, message):
        self.messages.append(message)

def get_messages(self, receiver):
        return [m for m in self.messages if m.receiver == receiver]

class Account:
def __init__(self, business_name, contact_info):
self.business_name = business_name
self.contact_info = contact_info

def update_account(self, business_name=None, contact_info=None):
        if business_name:
self.business_name = business_name
        if contact_info:
self.contact_info = contact_info

class Order:
def __init__(self, customer_name, product, quantity, status="Processing"):
self.customer_name = customer_name
self.product = product
self.quantity = quantity
self.status = status

def update_status(self, status):
self.status = status

class OrderManager:
def __init__(self):
self.orders = []

def place_order(self, order):
        self.orders.append(order)

def get_order_status(self, order):
        for o in self.orders:
        if o == order:
        return o.status
        return None
