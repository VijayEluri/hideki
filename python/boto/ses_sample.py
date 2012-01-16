from boto.ses import SESConnection

AWS_ACCESS_KEY_ID       = '<access key>'
AWS_SECRET_ACCESS_KEY   = '<secret access key>'

def main():
    print 'boto Amazon SMS sample'
    source = 'smilogram@gmail.com'
    subject = 'hello SES!'
    body = '<html><body style="color:blue;background:Cornsilk;">email message from python!</body></html>'
    to_addresses = ['h.itakura@yahoo.com', 'hideki.itakura@gmail.com']
    connection = SESConnection(aws_access_key_id=AWS_ACCESS_KEY_ID, aws_secret_access_key=AWS_SECRET_ACCESS_KEY)
    connection.send_email(source=source, subject=subject, body=None, to_addresses=to_addresses, format='html', html_body=body)

if __name__ == '__main__':
    main()
