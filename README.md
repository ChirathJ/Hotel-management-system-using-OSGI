# Hotel-management-system-using-OSGI

This is a scenario based in a hotel system. There are 6 producers and 5 consumers.
Manager, Customer, Bartender, Receptionist and Hotel food service (Chef) are the consumers,
while
Employee Producer, Login Producer, Room Producer, Bill Producer, Bar and Hotel food service
are the publishers.
To achieve best practices of OSGI we have exposed the producer service interfaces only, not the
implementations. Consumers can work through the interfaces.
