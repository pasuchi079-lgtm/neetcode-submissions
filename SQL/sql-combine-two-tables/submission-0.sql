Select p.first_name, p.last_name, a.city, a.state
from person p
LEFT JOIN address a on p.person_id = a.person_id;
