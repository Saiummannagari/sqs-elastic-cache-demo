AWS does not allow ANY outside connections to elasticache. 
You cannot connect to it from anywhere other than an instance hosted through 
AWS (like ec2) and it must also be in the same security group with the appropriate 
ports configured. 
If you are attempting to access the elasticache from anywhere that is not an
AWS hosted instance you will get the "Connection Timed Out" error.



https://github.com/predis/predis/issues/541